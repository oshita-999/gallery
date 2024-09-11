package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.ImageItem;

public class ImageDaoImpl implements ImageDao {

	private DataSource ds;

	public ImageDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<ImageItem> allImageItem() {
		List<ImageItem> imageItem = new ArrayList<>();
		String sql = "SELECT * FROM images";

		try (Connection con = ds.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
//				Date date =  rs.getTimestamp("created");
				ImageItem item = ImageItem.builder().id(rs.getInt("id")).imageName(rs.getString("image_name"))
						.title(rs.getString("title")).userId(rs.getInt("user_id")).created(rs.getTimestamp("created"))
						.build();
				imageItem.add(item);
				System.out.println(item);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return imageItem;
	}

	@Override
	public void addImage(String imageName, String title, Integer id) {
		String sql = "INSERT INTO images(image_name, title, user_id, created) VALUES(?, ?, ?, now())";
		try (Connection con = ds.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, imageName);
			stmt.setString(2, title);
			stmt.setInt(3, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public ImageItem imageItemById(int id) {
		String sql = "SELECT *, owners.name  FROM images JOIN owners ON images.user_id = owners.id WHERE images.id = ?";

		ImageItem item = null;
		try (Connection con = ds.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				item = ImageItem.builder().id(rs.getInt("id")).imageName(rs.getString("image_name"))
						.title(rs.getString("title")).userName(rs.getString("owners.name")).created(rs.getTimestamp("created"))
						.build();
				System.out.println(item);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return item;
	}
}
