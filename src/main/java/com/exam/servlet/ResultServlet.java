package com.exam.servlet;

import com.exam.model.ExamResult;
import com.exam.service.FileService;
import com.exam.service.GradingService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/submitResult")
public class ResultServlet extends HttpServlet {
    private GradingService gradingService = new GradingService();
    private FileService fileService = new FileService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Extract values submitted from the frontend HTML/JSP form
        String id = request.getParameter("studentId");
        String exam = request.getParameter("examName");
        int score = Integer.parseInt(request.getParameter("score"));

        // 2. Compute grades and assign your dynamic comments
        ExamResult result = gradingService.processExamScore(id, exam, score);

        // 3. Write data to your results.txt database layer
        fileService.saveResultToFile(result);

        // 4. Send processed object back to display on the result view page
        request.setAttribute("examResult", result);
        request.getRequestDispatcher("displayResult.jsp").forward(request, response);
    }
}