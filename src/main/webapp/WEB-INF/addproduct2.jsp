<%--
  Created by IntelliJ IDEA.
  User: Levon
  Date: 13.03.2021
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addVeggiesFruits" method="get">
    <input type="text" name="name" placeholder="Գրեք ապրանքի անունը"><br><br>
    <input type="text" name="price" placeholder="նշեք գինը"><br><br>
    <input type="text" name="discount" placeholder="Զեղչված գինը(ոչ պարտադիր)"><br><br>
    <input type="text" name="description" placeholder="նշել նկարագրությունը"><br><br>
    <input type="file" name="img_url" placeholder="նկար"><br><br>
    <label for="VeggiesFruits">Veggies & Fruits</label><br>
    <select name="category" id="VeggiesFruits">
            <option value="fruits">Մրգեր</option>
            <option value="veggies">Բանջարեղեն</option>
            <option value="berries">Հատապտուղ</option>
    </select>
    <br><br>
    <input type="submit" value="Ավելացնել">
</form>
</body>
</html>
