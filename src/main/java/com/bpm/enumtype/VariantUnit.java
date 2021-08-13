package com.bpm.enumtype;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VariantUnit {
  ML("ml"), G("g"), PIECE("件");
  private String chName;
}
