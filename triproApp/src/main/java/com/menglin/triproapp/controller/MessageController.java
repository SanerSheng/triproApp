package com.menglin.triproapp.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.menglin.triproapp.entity.Message;
import com.menglin.triproapp.entity.User;
import com.menglin.triproapp.service.IMessageService;
import com.menglin.triproapp.util.PageBean;
import com.menglin.triproapp.util.SystemParam;
import com.menglin.triproapp.vo.PageRuslt;

/** 
 * @author CGS 
 * @date 2018年2月10日 上午10:59:43 
 */
@Controller  
@RequestMapping("/admin/message")
public class MessageController {
	
	@Resource  
    private IMessageService messageService;
	
	
	@RequestMapping(value="/findByPage.json",method={RequestMethod.POST})  
    public @ResponseBody PageRuslt<Message> findByPage(int currentPage, int pageSize,Message model){
		System.out.println("findByPage 方法");
		System.out.println(SystemParam.DOMAIN_NAME);
		PageRuslt<Message> pageRuslt =new PageRuslt<Message>();
		PageBean<Message> PageUser=messageService.findByPage(currentPage, pageSize, model);
		pageRuslt.setPageBean(PageUser);
      return pageRuslt;
	}    
}