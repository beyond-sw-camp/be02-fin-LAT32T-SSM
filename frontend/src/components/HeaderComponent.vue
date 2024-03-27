<template>
  <header class="header">
    <nav class="nav">
      <div class="icons">
        <a href="#"><i class="fas fa-arrow-left"></i></a>
        <a href="#" class="grey"><i class="fas fa-arrow-right"></i></a>
        <a href="#"><i class="far fa-clock"></i></a>
      </div>
      <form action="." class="search-bar">
        <i class="fas fa-search"></i>
        <input type="search" name="search" id="search" placeholder="Search Slack" class="search-bar-input" />
      </form>

      <div class="move-left">
        <a href="#"><i class="far fa-question-circle"></i></a>
        <div class="user-img-wrapper" id="user">
          <img src="images/user2.jpg" alt="User 1" />
          asdf
        </div>
      </div>
    </nav>
  </header>
</template>
<script>
export default {
  name: "HeaderComponent",
};
</script>

<style>
/*!
 * Font Awesome Free 5.14.0 by @fontawesome - https://fontawesome.com
 * License - https://fontawesome.com/license/free (Icons: CC BY 4.0, Fonts: SIL OFL 1.1, Code: MIT License)
 */

 .fa,.fas,.far {
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  display: inline-block;
  font-style: normal;
  font-variant: normal;
  text-rendering: auto;
  line-height: 1;
}

.fa-1x {
  font-size: 1em;
}

.fa-2x {
  font-size: 2em;
}

.fa-3x {
  font-size: 3em;
}

.fa-4x {
  font-size: 4em;
}

.fa-5x {
  font-size: 5em;
}

.fa-6x {
  font-size: 6em;
}

.fa-7x {
  font-size: 7em;
}

.fa-8x {
  font-size: 8em;
}

.fa-9x {
  font-size: 9em;
}

.fa-10x {
  font-size: 10em;
}

@-webkit-keyframes fa-spin {
  0% {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }

  100% {
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}

@keyframes fa-spin {
  0% {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }

  100% {
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}

/* Font Awesome uses the Unicode Private Use Area (PUA) to ensure screen
 readers do not read off random characters that represent icons */

.fa-arrow-alt-circle-left:before {
  content: "\f359";
}

.fa-arrow-alt-circle-right:before {
  content: "\f35a";
}

.fa-arrow-circle-left:before {
  content: "\f0a8";
}

.fa-arrow-circle-right:before {
  content: "\f0a9";
}

.fa-arrow-left:before {
  content: "\f060";
}

.fa-arrow-right:before {
  content: "\f061";
}

.fa-circle:before {
  content: "\f111";
}

.fa-clock:before {
  content: "\f017";
}

.fa-css3:before {
  content: "\f13c";
}

.fa-css3-alt:before {
  content: "\f38b";
}

.fa-edge:before {
  content: "\f282";
}

.fa-html5:before {
  content: "\f13b";
}

.fa-icons:before {
  content: "\f86d";
}

.fa-images:before {
  content: "\f302";
}

.fa-js:before {
  content: "\f3b8";
}

.fa-link:before {
  content: "\f0c1";
}

.fa-question:before {
  content: "\f128";
}

.fa-question-circle:before {
  content: "\f059";
}

.fa-search:before {
  content: "\f002";
}

.fa-slack:before {
  content: "\f198";
}

.fa-user:before {
  content: "\f007";
}

.fa-user-alt:before {
  content: "\f406";
}

.fa-user-circle:before {
  content: "\f2bd";
}

.fa-user-clock:before {
  content: "\f4fd";
}

@font-face {
  font-family: 'Font Awesome 5 Brands';
  font-style: normal;
  font-weight: 400;
  font-display: block;
  src: url("../webfonts/fa-brands-400.eot");
  src: url("../webfonts/fa-brands-400.eot?#iefix") format("embedded-opentype"), url("../webfonts/fa-brands-400.woff2") format("woff2"), url("../webfonts/fa-brands-400.woff") format("woff"), url("../webfonts/fa-brands-400.ttf") format("truetype"), url("../webfonts/fa-brands-400.svg#fontawesome") format("svg");
}

@font-face {
  font-family: 'Font Awesome 5 Free';
  font-style: normal;
  font-weight: 400;
  font-display: block;
  src: url("../webfonts/fa-regular-400.eot");
  src: url("../webfonts/fa-regular-400.eot?#iefix") format("embedded-opentype"), url("../webfonts/fa-regular-400.woff2") format("woff2"), url("../webfonts/fa-regular-400.woff") format("woff"), url("../webfonts/fa-regular-400.ttf") format("truetype"), url("../webfonts/fa-regular-400.svg#fontawesome") format("svg");
}

.far {
  font-family: 'Font Awesome 5 Free';
  font-weight: 400;
}

@font-face {
  font-family: 'Font Awesome 5 Free';
  font-style: normal;
  font-weight: 900;
  font-display: block;
  src: url("../webfonts/fa-solid-900.eot");
  src: url("../webfonts/fa-solid-900.eot?#iefix") format("embedded-opentype"), url("../webfonts/fa-solid-900.woff2") format("woff2"), url("../webfonts/fa-solid-900.woff") format("woff"), url("../webfonts/fa-solid-900.ttf") format("truetype"), url("../webfonts/fa-solid-900.svg#fontawesome") format("svg");
}

.fa,.fas {
  font-family: 'Font Awesome 5 Free';
  font-weight: 900;
}

html,body,div,a,img,i,form,header,nav {
  margin: 0;
  padding: 0;
  border: 0;
  font: inherit;
  font-size: 100%;
  vertical-align: baseline;
}

html {
  line-height: 1;
  position: relative;
  height: 100%;
  font-size: 1rem;
  font-family: Lato, sans-serif;
  --slack-blue: #376cdf;
  --slack-dark-blue: darkblue;
  --slack-cyan: #6ecadc;
  --slack-green: #3eb991;
  --slack-red: #e01563;
  --slack-yellow: #e9a820;
  --slack-tag-background: #f8f8f8;
  --slack-tag-border-color: rgba(97, 96, 97, 1);
  --slack-tag-forecolor: rgba(134, 134, 134, 1);
  --slack-search-background: #073642;
  --slack-background: #350d36;
  --slack-input-border-color: rgba(29, 28, 29, 0.5);
  --dark-grey: #9e9a9a;
  --slack-other-bckground: #3f0e40;
  --slack-white: #cfc3cf;
  --slack-border-color: rgb(82, 38, 83);
  --slack-main-white: #ffffff;
  --light-gray: #f1f3f5;
}

body {
  margin: 0;
  font-family: Lato, -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto",
    "Oxygen", "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue",
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 100%;
  width: 100%;
  text-align: justify;
  overflow: hidden;
}

a img {
  border: none;
}

header {
  display: block;
}

nav {
  display: block;
}

* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  outline: none;
}

body::-webkit-scrollbar {
  width: 0.125rem !important;
}

body::-webkit-scrollbar-track {
  box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

body::-webkit-scrollbar-thumb {
  background-color: darkgray;
  outline: 1px solid slategray;
}

/* Header and navigation  */

.header {
  grid-row: 1 / 2;
  width: 100%;
}

.nav {
  width: 100%;
  background: var(--slack-background);
  display: flex;
  align-items: center;
  box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.1);
  padding: 0.5rem;
}

.nav .icons {
  display: flex;
  align-items: center;
  margin-left: 14rem;
}

.nav .icons a {
  margin-right: 2rem;
  font-size: 1.25rem;
  color: var(--slack-main-white);
}

.nav .icons .grey {
  color: var(--dark-grey);
}

.nav .search-bar {
  display: flex;
  align-items: center;
  position: relative;
}

.search-bar-input {
  /* max-width: 31.25rem; */
  /* min-width: 0; */
  width: 31.25rem;
  height: 1.5rem;
  border: 0.1rem solid var(--slack-border-color);
  border-radius: 0.375rem;
  background-color: rgb(67, 30, 68);
  padding-left: calc(30rem - 23rem);
  box-shadow: inset 0 0 0 1px rgb(104, 74, 104);
  transition: all 0.5s ease-out;
}

.search-bar-input:focus {
  background-color: var(--slack-background);
  color: var(--slack-white);
}

.search-bar-input::placeholder {
  color: var(--slack-white);
}

.search-bar i {
  position: absolute;
  font-size: 0.7rem;
  left: 5rem;
  color: var(--slack-white);
}

.nav .move-left {
  margin-left: auto;
  margin-right: 2rem;
  display: flex;
  align-items: center;
}

.nav .move-left i {
  font-size: 1.125rem;
  color: var(--slack-main-white);
}

.nav .move-left .user-img-wrapper {
  width: 1.5rem;
  height: 1.5rem;
  display: none;
}

.nav .move-left .user-img-wrapper img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  margin-left: 0.5rem;
  border-radius: 0.325rem;
}

/* main */

/* fixed sidebar */

/* body  */

.body {
  grid-column: 2 / -1;
  background-color: var(--slack-main-white);
  border-right: 0.1rem solid rgba(29, 28, 29, 0.13);
  display: grid;
  grid-template-columns: 1.5fr 1fr;
}

/* body content */

.content {
  grid-column: 1 / 1;
  height: 100vh;
  border-right: 0.1rem solid var(--slack-white);
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto 1fr 10rem;
  grid-template-areas: "header"
    "main"
    "footer";
}

/* body right-sidebar */

/* first left-sidebar */

/* second left-sidebar */

/* first left-sidebar content */

/* first left-sidebar ended */

/* second left-sidebar content */

/* user info */

/* adds border-bottom to all section elements except the last one*/

/* user info ends */

/* unread starts */

/* unread ends */

/* channels starts */

/* channels ends */

/* direct messages  */

/* channels starts */

/* end of direct messages  */

/* body */

/* body content */

.content-header {
  /* position: fixed;
  width: 48%; */
  grid-area: header;
  display: flex;
  align-items: center;
  background-color: #fff;
  border-bottom: 0.1rem solid var(--slack-white);
  box-shadow: 0 0 0.2rem -0.2rem rgba(0, 0, 0, 0.3);
  overflow: hidden;
}

.content-header-icons {
  display: flex;
  align-items: center;
}

.content-header-icons {
  margin-bottom: 0.4rem;
  display: flex;
  align-items: center;
}

.content-header-icons i {
  font-size: 0.8rem;
  margin-right: 0.2rem;
}

/* feeds */

/* end of feeds */

/* form/footer begins */

.form {
  grid-area: footer;
  height: 80%;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

.form .input {
  width: 90%;
  height: 40%;
  margin-top: 2%;
  margin-right: 5%;
  margin-left: 5%;
  padding: 0.6rem;
  border-top-left-radius: 0.3125rem;
  border-top-right-radius: 0.3125rem;
  outline: none;
  border-top: 0.0625rem solid var(--slack-input-border-color);
  border-left: 0.0625rem solid var(--slack-input-border-color);
  border-right: 0.0625rem solid var(--slack-input-border-color);
  border-bottom: none;
  overflow: auto;
}

.move-right > i:first-of-type {
  border-right: 0.1rem solid var(--slack-tag-border-color);
}

.move-right {
  margin-right: auto;
}

.move-left {
  margin-left: auto;
  display: flex;
  align-items: center;
}

/* end of feeds */

/* end of body content */

/* starts right-sidebar */

/* ends right-sidebar */

/* end of body */

/* Channels creation */

.header-wrapper {
  position: relative;
}

.form-header {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
}

/* end of channel creation */

/* card */

.user-name {
  font-weight: bold;
  display: flex;
  align-items: center;
  margin-bottom: 0.3rem;
}

.user-name i {
  margin-left: 0.5rem;
  font-size: 0.6rem;
  color: var(--slack-green);
}

.user-title {
  font-weight: normal;
  font-size: 1rem;
}

/* end of card */

.input:empty::before {
  content: attr(data-placeholder);
  color: #9e9a9a;
}

@media (max-width: 1250px) {
  .body {
    grid-template-columns: 1.5fr;
  }

  .content {
    grid-column: 1 / -1;
  }
}

@media (max-width: 960px) {
  .nav .icons {
    margin-left: 2rem;
  }
}

@media (max-width: 806px) {
  .nav .icons {
    margin-left: 0.5rem;
  }
}

@media (max-width: 724px) {
  .body {
    grid-column: 1 / -1;
  }

  .search-bar-input {
    width: 100%;
  }

  .nav .move-left .user-img-wrapper {
    display: block;
  }
}

@media (max-width: 600px) {
  .header-wrapper {
    position: static;
  }

  .form-header {
    font-size: 1rem;
    font-weight: bold;
    margin-bottom: 0.5rem;
  }
}

@media (max-width: 500px) {
  .search-bar-input {
    padding-left: 2rem;
  }

  .search-bar i {
    left: 0.5rem;
  }
}

@media (max-width: 422px) {
  .nav .icons a {
    margin-right: 0.8rem;
  }

  .nav .move-left {
    margin-left: 1rem;
  }
}

@media (max-width: 326px) {
  .content-header-icons i {
    font-size: 0.7rem;
    margin-right: 0.1rem;
  }
}

@media (max-width: 304px) {
  .search-bar-input {
    padding-left: 1rem;
  }

  .search-bar i {
    left: 0.1rem;
  }
}
</style>
