package ksmart.ocltest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart.ocltest.dto.FileDto;
import ksmart.ocltest.mapper.FileMapper;
import ksmart.ocltest.util.FileUtil;

@Service
@Transactional
public class FileService {
	
	private FileUtil fileUtil;
	private FileMapper fileMapper;	
	
	public FileService(FileUtil fileUtil, FileMapper fileMapper) {
		
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}

	public void fileUpload(MultipartFile[] uploadfile, String fileRealPath) {
		
		List<FileDto> fileList= fileUtil.parseFileInfo(uploadfile, fileRealPath);
				
		if(fileList != null) fileMapper.addFile(fileList);
		
	}
	
	public List<FileDto> getFileList(){
		List<FileDto> fileList = fileMapper.getFileList();
		
		return fileList;
	}
	
	public FileDto getFileInfoByIdx(String fileIdx) {
		return fileMapper.getFileInfoByIdx(fileIdx);
	}
}
