package com.yi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/*@Inject
	private BoardService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	// sBoard/list?page=10
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(SearchCriteria cri, Model model) {
		logger.info("list ----- get");
		List<BoardVO> list = service.listSearch(cri);

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
	public String registerPost(BoardVO vo, List<MultipartFile> imageFiles) throws IOException {
		logger.info("register ----- post");
		logger.info(vo.toString());
		
		List<String> files = new ArrayList<>();
		for (MultipartFile file : imageFiles) {
			logger.info("file name : " + file.getOriginalFilename());
			logger.info("file size : " + file.getSize());
			
			String thumbPath = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			
			files.add(thumbPath);
		}
		vo.setFiles(files);
		
		service.regist(vo);

		return "redirect:/board/list";
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Criteria cri, Model model) {
		logger.info("read ----- get");
		BoardVO vo = service.read(bno);
		model.addAttribute("boardVO", vo);
		model.addAttribute("cri", cri);
		
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(int bno, Criteria cri, Model model) {
		logger.info("modify ----- get");
		BoardVO vo = service.read(bno);
		model.addAttribute("boardVO", vo);
		model.addAttribute("cri", cri);
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO vo, int bno, Criteria cri, String[] delFiles, List<MultipartFile> addfiles, Model model) throws IOException {
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

		return "redirect:/board/read?bno=" + vo.getBno() + "&page=" + cri.getPage();
	}

	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String remove(int bno, Criteria cri, Model model) {
		logger.info("remove ----- post");
		service.remove(bno);
		model.addAttribute("cri", cri);

		return "redirect:/board/list?page=" + cri.getPage();
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
	}*/

}
