package dao;

import java.util.List;

import entity.computer;

public interface dao {
	public List<computer> allComputer();

	public computer findById(int id);
}
