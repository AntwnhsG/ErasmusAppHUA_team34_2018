package erasmusApp_package.dao;

import java.util.List;

import erasmusApp_package.entity.University;
// see UniversityDAOImpl
public interface UniversityDAO {
	public List<University> getUniversities();
	public String setUniversity (/*int univ_id, */String country, String city, String univ_name, int avRoom);
	public University getUniversity(int id);
	public String updateUniversity (String columnName, String newValue, String id);
	public String deleteUniversity(String id);
}
