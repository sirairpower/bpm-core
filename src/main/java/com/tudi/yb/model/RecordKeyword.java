package com.tudi.yb.model;

import com.tudi.yb.model.RecordKeyword.RecordKeywordPK;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "record_keyword")
@IdClass(RecordKeywordPK.class)
public class RecordKeyword implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class RecordKeywordPK implements  Serializable{
    private Long recordId;
    private String name;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Id
  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "keyword_type", nullable = false)
  private Integer keywordType;

  @Column(name = "doctor_id", nullable = false)
  private Long doctorId;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
