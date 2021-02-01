package boot.shop.data;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("shop")
public class ShopDto {
	private String num;
	private String sangpum;
	private int price;
	private String photoname;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
 	private Timestamp ipgoday;
}
