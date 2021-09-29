package com.vision.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vision.dao.BoardDAO;
import com.vision.dto.BoardDTO;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		BoardDAO dao = new BoardDAO();
		dao.modify(bid, bname, btitle, bcontent);
	}

}
