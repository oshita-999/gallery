package dao;

import java.util.List;

import domain.ImageItem;

public interface ImageDao {
	List<ImageItem> allImageItem();
	ImageItem imageItemById(int id);
	void addImage(String imageName, String title, Integer id);
}
