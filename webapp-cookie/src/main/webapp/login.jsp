<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
  <h2>Login:</h2>
    <form action="/webapp-cookie/login" method="post">
      <div>
        <label for="username">Username:</label>
        <div>
          <input type="text" name="username" id="username" placeholder="Enter username" required>
        </div>
      </div>
      <div>
        <label for="password">Password:</label>
        <div>
          <input type="password" name="password" id="password" placeholder="Enter password" required>
        </div>
      </div>
      <div>
        <input type="submit" value="Login">
      </div>
    </form>

</body>
</html>