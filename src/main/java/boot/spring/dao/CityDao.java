package boot.spring.dao;

import java.util.List;

import boot.spring.po.City;
import boot.spring.po.Country;
import org.springframework.stereotype.Component;

@Component(value = "cityMapper")
public interface CityDao {
	void addCity();
	void addCountry();
	List<City> getCitys();
	List<City> getCountrycity(String countryname);//获取某国家城市列表
	Country getCitysbyCountry(String countryname);
}
