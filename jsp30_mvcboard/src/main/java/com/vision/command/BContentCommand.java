package com.vision.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vision.dao.BoardDAO;
import com.vision.dto.BoardDTO;
//리스트 목록에서 선택한 상세 내용 보기에 활용
public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.contentView(bid);
		request.setAttribute("content_view", dto);
		
	}
}
