package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.entity.Task;
import com.example.api.rerpository.TaskRepository;

@Service
public class TaskService{

	@Autowired
	
	private TaskRepository taskRepository;

	public List<Task> getAllTasks(){
		return taskRepository.findAll();
		
	}
	 public Optional<Task> getTaskById(Long id){
		 return taskRepository.findById(id);
	 }
	 public Task createTask(Task task) {
	        return taskRepository.save(task);
	    }
	 public Task updateTask(Long id, Task updateTask) {
	        return taskRepository.findById(id).map(task -> {
	            task.setTask(updateTask.getTask());
	            return taskRepository.save(task);
	        }).orElse(null);
	    }
	 public void deleteTask(Long id) {
	        taskRepository.deleteById(id);
	    }

}
