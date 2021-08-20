package com.bpm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString.Exclude;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "shopee_variant_prod")
public class ShopeeVariantProd implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "price")
  private Integer price;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "variant_unit")
  private Integer variantUnit;

  @Column(name = "description")
  private String description;

  @Column(name = "sold_out")
  private Boolean soldOut;
  @Column(name = "variant_img")
  private String variantImg;

  @Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_info_id")
  private ShopeeProductInfo shopeeProductInfo;

}
