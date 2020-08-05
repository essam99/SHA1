<html>
  <head>
    <title>Digital Signature SHA-1</title>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,700" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />
  </head>
  
  <body>
    <%@page import="Classes.sha1"%>
    <% sha1 sha = new sha1(); %>
    <div class="s013">
      <form action="" method="post">
        <fieldset>
          <legend>DIGITAL SIGNATURE SHA-1</legend>
        </fieldset>
        <div class="inner-form">
          <div class="left">
            <div class="input-wrap first">
              <div class="input-field first">
                <label>TEXT</label>
                <input type="text" name="txt" placeholder="<%out.print(request.getParameter("txt"));%>" />
              </div>
            </div>
          </div>
          <input type="submit" class="btn-search" value="HASH">       
          </div>
            <br />
            <div class="inner-form">
                <div class="input-wrap" style="width:100%;background: #dff2e4">
                    <div class="input-field">
                      <label>HASH VALUE</label>
<textarea name="txt" style="margin-top:12px;resize: none;border:0;width:100%;background:transparent;font-size:12pt;color:#333;" disabled>
<%out.print(sha.get_SHA1(request.getParameter("txt")));%>
</textarea>
                    </div>
                </div> 
            </div>
      </form>
    </div>
  </body>
</html>