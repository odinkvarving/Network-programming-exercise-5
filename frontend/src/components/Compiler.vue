<template>
  <div class = "container">
    <h1>The C++ Compiler for dummies</h1>
    <textarea class = "code-input" id = "code-input" placeholder = "Write some c++ code here... " onfocus = "this.placeholder = ''" onblur = "this.placeholder = 'Write some c++ code here...'"> </textarea>

    <div class = "button-container">
      <button class = "compile-button" v-on:click="compileCode()">Compile</button>
    </div>

    <textarea class = "code-output" placeholder = "Output from code..." onfocus = "this.placeholder = ''" onblur = "this.placeholder = 'Output from code...'"></textarea>
  </div>
</template>

<script>
  export default {
    name: 'Compiler',

    methods: {
      compileCode() {
        let code = {
          "code" : document.getElementById("code-input").value
        };
        console.log(document.getElementById("code-input").value);

        const requestOptions = {
          method: "POST",
          headers: {"Content-Type" : "application/json"},
          body: JSON.stringify(code)
        };

        fetch("http://localhost:8080/compiler", requestOptions)
                .then(response => response.json())
                .then(data => {
                  console.log(data.code);
                  if(!data.code || data.code === "") {
                    document.querySelector(".code-output").value = "ERROR: Could not compile the C++ input code. Please check format."
                  }else {
                    document.querySelector(".code-output").value = data.code;
                  }
                })
                .catch(error => console.log(error));
        }
      }
    }
</script>

<style>

  h1 {
    color: azure;
  }

  body {
    background: #121212;
  }

  .container {
    width: 500px;
    height: 100px;
    margin: 0 auto;
  }

  .code-input {
    width: 500px;
    height: 200px;
    resize: none;
    background-color: #222;
    color: azure;
  }

  .code-output {
    width: 500px;
    height: 200px;
    resize: none;
    background-color: #222;
    color: azure;
  }

  ::placeholder {
    color: azure;
  }

  .button-container {
    width: 500px;
    height: 40px;
    resize: none;
  }

  .compile-button {
    width: 100px;
    height: 35px;
    resize: none;
    background-color: Transparent;
    background-repeat: no-repeat;
    border: none;
    overflow: hidden;
    outline: none;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 17px;
    color: azure;
  }
</style>
