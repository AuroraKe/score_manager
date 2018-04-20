package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neu.bean.Classes;
import com.neu.dao.ClassesMapper;

@Service
public class ClassesService {
	@Autowired
	private ClassesMapper classesMapper;
	
	public void insert(String className) {
		classesMapper.insert(className);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<Classes> selectAll(){
		return classesMapper.selectAll();
	}

	//���ݰ༶IDɾ���༶��Ϣ
	public void deleteById(Integer class_id) {
		classesMapper.deleteById(class_id);
	}
	
	//���ݰ༶id���°༶����
	public void updateById(Integer class_id, String class_name) {
		classesMapper.updateById(class_id, class_name);
	}
	
	//��ѯ���а༶����
	public List<String> selectClassName(){
		return classesMapper.selectClassName();
	}
}
