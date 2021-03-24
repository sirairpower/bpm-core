package com.tudi.yb.model;

import com.tudi.yb.model.Dictionary.DictionaryPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "dictionary")
@IdClass(DictionaryPK.class)
public class Dictionary implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class DictionaryPK implements  Serializable{
    private String name;
    private Long itemType;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "name", nullable = false)
  private String name;

  @Id
  @Column(name = "item_type", nullable = false)
  private Long itemType;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

  @Column(name = "priority", nullable = false)
  private Long priority;

  @Column(name = "category_id", nullable = false)
  private Long categoryId;

}
