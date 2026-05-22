<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.exam.model.ExamResult" %>
<!DOCTYPE html>
<html>
<head>
    <title>Exam Performance Analysis</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 50px;
            display: flex;
            justify-content: center;
        }
        .result-card {
            background: #ffffff;
            width: 450px;
            padding: 35px;
            border-radius: 12px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
            text-align: center;
        }
        .header {
            color: #2c3e50;
            margin-bottom: 25px;
            font-size: 24px;
            border-bottom: 2px solid #ecf0f1;
            padding-bottom: 15px;
        }
        .info-group {
            display: flex;
            justify-content: space-between;
            margin: 15px 0;
            font-size: 16px;
            color: #7f8c8d;
        }
        .label { font-weight: 600; color: #34495e; }
        .value { color: #2c3e50; }
        .grade-badge {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 25px;
            font-size: 22px;
            font-weight: bold;
            color: #fff;
            background-color: #2ecc71;
            border-radius: 50px;
            text-transform: uppercase;
        }
        .comment-box {
            margin-top: 25px;
            background: #f8f9fa;
            padding: 15px;
            border-left: 4px solid #3498db;
            border-radius: 4px;
            text-align: left;
            font-style: italic;
            color: #555;
        }
    </style>
</head>
<body>

<div class="result-card">
    <div class="header">Exam Report Card</div>

    <%
        // Read the processed object sent by your ResultServlet
        ExamResult examResult = (ExamResult) request.getAttribute("examResult");
        if (examResult != null) {
    %>
        <div class="info-group">
            <span class="label">Student ID:</span>
            <span class="value"><%= examResult.getStudentId() %></span>
        </div>
        <div class="info-group">
            <span class="label">Exam Module:</span>
            <span class="value"><%= examResult.getExamName() %></span>
        </div>
        <div class="info-group">
            <span class="label">Raw Score:</span>
            <span class="value"><%= examResult.getScore() %></span>
        </div>

        <div class="grade-badge">
            Grade: <%= examResult.getGrade() %>
        </div>

        <div class="comment-box">
            <strong>Evaluator Comment:</strong> <br>
            "<%= examResult.getComment() %>"
        </div>
    <%
        } else {
    %>
        <div style="color: red; font-weight: bold;">No exam processing data found.</div>
    <%
        }
    %>
</div>

</body>
</html>