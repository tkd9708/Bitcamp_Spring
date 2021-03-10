package day1216.spring.ex7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MappingTestController {
	
	@GetMapping("/mapping")
	public String gomapping() {
		return "views/mappingtest";
	}
	
	// 여러개의 매핑주소가 같은 로직을 처리하고자할 경우
	@GetMapping({"/board/list", "/guest/list", "/member/list"})
	public String list() {
		return "views/list";
	}
	
	@GetMapping("/shop/{path1}")
	public String changeUrl(Model model, @PathVariable("path1") String p1) {
		if(p1.equals("cart"))
			model.addAttribute("msg", "장바구니의 내용을 출력했어요!");
		else if(p1.equals("list"))
			model.addAttribute("msg", "상점의 전체 목록을 출력했어요!");
		else if(p1.equals("save"))
			model.addAttribute("msg", "선택한 상품을 저장했어요!");
		
		model.addAttribute("mypath", p1);
		return "views/list2";
	}
	
	// 매핑주소가 겹칠경우 매핑주소가 확실하게 정의된 메서드가 우선 호출된다.
	// 따라서 위의 것이 아닌 아래 것이 호출됨
	@GetMapping("/shop/list")
	public String goList(Model model) {
		model.addAttribute("msg", "상품 목록인데 독립된 로직으로 처리할거예요");
		model.addAttribute("mypath", "list");
		
		return "views/list2";
	}
}
