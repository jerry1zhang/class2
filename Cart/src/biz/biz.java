package biz;

import java.util.List;

import entity.computer;

public interface biz {
	public List<computer> allComputer();
	public computer findById(int id);
}
