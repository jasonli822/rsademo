var Login = function () {
  var publicKey = {}
  var getPublicKey = function () {
    $.ajax({
      url: "getKey",
      type: "POST",
      async: false
    }).done(function (data) {
      publicKey = data
    });
  }

  var handleLogin = function () {
    var formStr = function () {
      var data = {}
      data.username = $("input[name='username']").val()
      data.password = $("input[name='password']").val()
      return JSON.stringify(data)
    }

    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey.pubKey);

    $("#btnLogin").click(function () {
      $.ajax({
        url: "login",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({keyId: publicKey.id, secretText: encrypt.encrypt(formStr())}),
        success: function (data) {
          if (data) {
            alert("登陆成功")
          } else {
            alert("登陆失败")
          }
        }
      })
    });
  }

  return {
    //main function to initiate the module
    init: function () {
      getPublicKey();
      handleLogin();
    }
  };
}();
