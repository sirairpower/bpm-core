package com.bpm.service;

public interface DownloadService {

  void loadFileToLocal();

  String getFilePathAbsolute(String fileName);
}
