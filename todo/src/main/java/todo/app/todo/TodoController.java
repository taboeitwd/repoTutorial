package todo.app.todo;

import java.util.Collection;

import javax.inject.Inject;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import todo.domain.model.Todo;
import todo.domain.service.todo.TodoService;

@Controller
@RequestMapping("todo")
public class TodoController {
	@Inject	TodoService	todoService;
	@Inject	Mapper		beanMapper;
	
	@ModelAttribute
	public TodoForm setUpForm() {
		TodoForm form = new TodoForm();
		return form;
	}
	
	@RequestMapping(value = "list" , method = RequestMethod.GET)
	public String list(Model model) {
		Collection<Todo> todos = todoService.findAll();
		model.addAttribute("todos",todos);
		return "todo/list";
	}
	
	@RequestMapping(value = "create" , method = RequestMethod.POST)
	public String create(Model model , @Valid TodoForm todoForm , BindingResult bindingResult , RedirectAttributes attributes) {
		
		if (bindingResult.hasErrors()) {
			return list(model);
		}
		
		Todo todo = beanMapper.map(todoForm, Todo.class);
		try {
			todoService.create(todo);
		}
		catch (BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return list(model);
		}
		
		attributes.addFlashAttribute(ResultMessages.success().add(ResultMessage.fromText("Created successfully!")));
		
		return "redirect:/todo/list";
	}
}
