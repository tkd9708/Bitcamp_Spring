package boot.shop.data;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MysqlShopMapper {
	public int getTotalCount();
	public List<ShopDto> getAllDatas();
	public void insertShop(ShopDto dto);
	public ShopDto getData(String num);
	public void updateShop(ShopDto dto);
	public void deleteShop(String num);
}
