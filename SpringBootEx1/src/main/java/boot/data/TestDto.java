package boot.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString

// 위의 3개를 모두 합친 어노테이션이 @Data
@Data
public class TestDto {
	private String sang;
	private int su;
	private int dan;
}
