package todo.app.todo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min = 1, max = 30)
	private String todoTitle;

	public String getTodoTitle() {
		return todoTitle;
	}

	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	

}
