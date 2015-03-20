package todo.domain.repository.todo;

import java.util.Collection;

import todo.domain.model.Todo;

public interface TodoRepository {
	Todo	findOne(String	todoId);
	Collection<Todo>	findAll();

}
