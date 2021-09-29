package com.vision.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vision.dao.BoardDAO;
import com.vision.dto.BoardDTO;

public class BReplyViewCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.reply_view(bid);
		request.setAttribute("reply_view", dto);
		
	}
}
