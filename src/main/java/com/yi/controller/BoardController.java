package com.yi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yi.domain.Board;
import com.yi.domain.Criteria;
import com.yi.domain.PageMaker;
import com.yi.domain.SearchCriteria;
import com.yi.service.BoardService;
import com.yi.util.MediaUtils;
import com.yi.util.UploadFileUtils;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	// sBoard/list?page=10
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(SearchCriteria cri, Model model) {
		logger.info("list ----- get");
		List<Board> list = service.listSearch(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("cri", cri);
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGet() {
		logger.info("register ----- get");
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPost(Board board, List<MultipartFile> imageFiles) throws IOException {
		logger.info("register ----- post");
		logger.info(board.toString());
		
		List<String> files = new ArrayList<>();
		for (MultipartFile file : imageFiles) {
			logger.info("file name : " + file.getOriginalFilename());
			logger.info("file size : " + file.getSize());
			
			String thumbPath = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			
			files.add(thumbPath);
		}
		board.setFiles(files);
		
		service.regist(board);

		return "redirect:/sboard/list";
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Criteria cri, Model model) {
		logger.info("read ----- get");
		Board vo = service.read(bno);
		model.addAttribute("boardVO", vo);
		model.addAttribute("cri", cri);
		
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(int bno, Criteria cri, Model model) {
		logger.info("modify ----- get");
		Board vo = service.read(bno);
		model.addAttribute("boardVO", vo);
		model.addAttribute("cri", cri);
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(Board vo, int bno, Criteria cri, String[] delFiles, List<MultipartFile> addfiles, Model model) throws IOException {
		logger.info("modify ----- post");
		if (delFiles != null) {
			for (String delFile : delFiles) {
				logger.info(delFile);
				
				File file = new File(uploadPath + delFile);
				file.delete();
				
				String front = delFile.substring(0, 12);
				String end = delFile.substring(14);
				String originalFilename = front + end;
				File file2 = new File(uploadPath + originalFilename);
				file2.delete();
			}
		}
		
		List<String> addImages = new ArrayList<>();
		if (addfiles != null) {
			for (MultipartFile file : addfiles) {
				logger.info("file name = " + file.getOriginalFilename());
				logger.info("file size = " + file.getSize());
				if (file.getSize() > 0) {
					String thumb = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());

					addImages.add(thumb);
				}
				
			}
		}
		
		System.out.println(vo);
		service.modify(vo);
		service.modifyFile(vo, delFiles, addImages);
		
		model.addAttribute("page", cri.getPage());
		model.addAttribute("keyward", cri.getPerPageNum());

		return "redirect:/sboard/read?bno=" + vo.getBno() + "&page=" + cri.getPage();
	}

	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String remove(int bno, Criteria cri, Model model) {
		logger.info("remove ----- post");
		service.remove(bno);
		model.addAttribute("cri", cri);

		return "redirect:/sboard/list?page=" + cri.getPage();
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String filename) {
		ResponseEntity<byte[]> entity = null;

		logger.info("displayFile : " + filename);

		try {
			String format = filename.substring(filename.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(format);
			HttpHeaders headers = new HttpHeaders();
			InputStream in = null;

			in = new FileInputStream(uploadPath + "/" + filename);
			headers.setContentType(mType);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
