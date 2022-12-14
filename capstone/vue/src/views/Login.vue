<template>
  <body>
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1>Bender BeerFinder</h1>
        
        <div class="container">
          <img src="@/assets/bender_beer_locator.png" alt="Avatar" class="image">
            <div class="overlay">
            <div class="text">OOOO...Issa Match!</div>
          </div>
        </div>




        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>

        <div id="username">
          <label for="username" class="sr-only"></label>

          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </div>

        <div id="password">
          <label for="password" class="sr-only"></label>

          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
        <router-link id="create-account" :to="{ name: 'register' }"
          >Create Account</router-link
        >

        <button id="sign-in" type="submit">Sign in</button>
      </form>
    </div>

  </body>
</template>

<script>
import authService from "../services/AuthService";
export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
        role: "user",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            
            if (response.data.user.authorities[0].name == "ROLE_BREWER") {
              this.$router.push({ name: "breweries" });
            } else if (
              response.data.user.authorities[0].name == "ROLE_BEERLOVER"){
              this.$router.push({ name: "beerlover" });
            } else {
              this.$router.push("/home");
            }
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>

input::placeholder {
  color: black;
}
* {
  padding: 0;
  margin: 0;
}
input {
  display: block;
  height: 50px;
  width: 50vw;
  background-color: rgba(255, 255, 255, 0.829);
  border: 2px solid rgba(0, 0, 0, 0.383);
  border-radius: 3px;
  padding: 0 10px;
  margin-top: 4px;
  font-size: 17px;
  font-weight: 500;
  text-align: center;
  color: black;
  
 
}
body {
  text-align: center;
  display: flex;
  justify-content: center;
  align-items: center;


}
body,
html {
  height: 100vh;
}
h1 {
  font-weight: bolder;
  margin-bottom: 5%;
  font-size: 300%;
  color: darkgoldenrod;
  text-decoration: underline overline;
  text-decoration-style:solid;
}
h2 {
  font-weight: bolder;
  margin-bottom: 15%;
  color: darkgoldenrod;
}
#sign-in {
  margin-top: 2%;
  width: 51.3vw;
  height: 6vh;
  border: 2px solid rgba(255, 255, 255, 0.1);
  color: darkgoldenrod;
  font-size: 130%;
  font-weight: bold;
  background-color: black;
  cursor: pointer;
}
#login.text-center {
  width: 50vw;
}


.container {
  position: relative;
  width: 98%;
  align-content: center;
  }

.image {
  display: block;
  width: 98%;
  height: auto;
}

.overlay {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: black;
  overflow: hidden;
  width: 0;
  height: 100%;
  transition: .5s ease;
}

.container:hover .overlay {
  width: 100%;
}

.text {
  color: darkgoldenrod;
  font-size: 50px;
  font-weight: bold;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  white-space: nowrap;
  text-shadow: 0 0 3px red, 0 0 5px darkgoldenrod;
}

</style>
