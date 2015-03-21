package todo.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "todo")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private	String	todoId		;
	private	String	todoTitle	;
	private	boolean	finished	;
	@Temporal(TemporalType.TIMESTAMP)
	private	Date	createdAt	;
	
	public	String	getTodoId	()	{	return	todoId		;}
	public	String	getTodoTitle()	{	return	todoTitle	;}
	public	boolean	isFinished	()	{	return	finished	;}
	public	Date	getCreatedAt()	{	return	createdAt	;}

	public	void	setTodoId	(	String	todoId		)	{	this.todoId		=	todoId		;}
	public	void	setTodoTitle(	String	todoTitle	)	{	this.todoTitle	=	todoTitle	;}
	public	void	setFinished	(	boolean	finished	)	{	this.finished	=	finished	;}
	public	void	setCreatedAt(	Date	createdAt	)	{	this.createdAt	=	createdAt	;}
}
