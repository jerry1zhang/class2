package biz;

import java.util.List;

import dao.dao;
import dao.daoimpl;
import entity.computer;

public class bizimpl implements biz {
	private dao dao = new daoimpl();
	@Override
	public List<computer> allComputer() {
		return dao.allComputer();
	}
	@Override
	public computer findById(int id) {
		
		return dao.findById(id);
	}

}
