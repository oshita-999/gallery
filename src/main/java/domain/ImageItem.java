package domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ImageItem {
	private Integer id;
	private String imageName;
	private String title;
	private Integer userId;
	private String userName;
	private Date created;
}
