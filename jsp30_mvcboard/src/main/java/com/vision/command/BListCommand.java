package com.vision.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vision.dao.BoardDAO;
import com.vision.dto.BoardDTO;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.list();
		request.setAttribute("list", list);
		
	}

}
