package com.yi.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	public static String uploadFile(String uploadPath, // 업로드 경로
			String originalName, // 파일 이름
			byte[] fileData) throws IOException { // 파일 데이타
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath + "/" + savedName); // new File(uploadPath + savedPath, savedName)

		FileCopyUtils.copy(fileData, target);

		// thumbnail 이미지
		String thumbPath = makeThumbnail(uploadPath, savedPath, savedName);

		return thumbPath;
	}

	private static String makeThumbnail(String uploadPath, // c:/zzz/upload
			String path, //n /2019/02/13
			String fileName) throws IOException { // 원본 파일 이름ㄴ
		// 원본 이미지의 테이타를 가져와서 가상 이미지를 만듬
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		// 세로 100 크기에 고정하여 가로 너비는 자동 조절하도록 하여 thumbnail 데이타를 만듬
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		// thumbnail 파일명을 만듬 (s_를 붙임)
		String thumbnailName = uploadPath + path + "/" + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		// 만들어진 빈 thumbnail 파일에 destImg 데이타를 넣음
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);

		// thumbnail =용 파일 주소를 넘김
		return path + "/" + "s_" + fileName;
	}

	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = "/" + cal.get(Calendar.YEAR);
		String monthPath = String.format("%s/%02d", yearPath, cal.get(Calendar.MONTH) + 1);
		String datePath = String.format("%s/%02d", monthPath, cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, datePath);

		return datePath;
	}

	private static void makeDir(String uploadPath, String... paths) {
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);

			if (dirPath.exists() == false) {
				dirPath.mkdirs();
			}
		}
	}

}
