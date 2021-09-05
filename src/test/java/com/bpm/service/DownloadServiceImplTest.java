package com.bpm.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DownloadServiceImplTest {

  @Autowired
  DownloadService downloadService;

  @Value("${files.storage.path}")
  private String fileStoragePath;

  @Value("${java.io.tmpdir}")
  private String tmpdir;

  @Test
  void testDownload() {
    downloadService.loadFileToLocal();
  }

  @Test
  void testMP3() {
    
  }


}
