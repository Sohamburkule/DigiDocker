package com.DigiDocker.dao;

import java.util.List;
import com.DigiDocker.entity.Documents;
import com.DigiDocker.entity.User;

public interface UserDao {

    public int saveUser(User user);
	
	public User login(String email, String password);
	
	public int saveDocuments(Documents documents);
	
	public List<Documents> getDocumentsByUser(User user);
	
	public Documents getDocumentsById(int id);
	
	public void deleteDocuments(int id);

	void updateDocuments(Documents documents);
}
