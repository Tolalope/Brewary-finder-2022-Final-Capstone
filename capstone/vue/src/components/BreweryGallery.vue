<template>
  <body>
<div class="container">
            <div class="gallery">
                <figure class="gallery__item gallery__item--1">
                    <img src="https://www.crowneknox.com/resourcefiles/blogsmallimages/fun-things-to-do-in-knoxville-breweries-with-beer-gardens.jpg" alt="Gallery image 1" class="gallery__img">
                </figure>
                <figure class="gallery__item gallery__item--2">
                    <img src="https://www.newsnationnow.com/wp-content/uploads/sites/108/2022/05/BeersGettyImages-1221429432.jpg?w=1280" alt="Gallery image 2" class="gallery__img">
                </figure>
                <figure class="gallery__item gallery__item--3">
                    <img src="https://media.istockphoto.com/id/1093593288/photo/close-up-of-bartender-pouring-draft-beer-in-glass.jpg?s=612x612&w=0&k=20&c=qhSKb5v13QDuotRFV2HYAsVIlTkefv6wjTFqOBEkFXo=" alt="Gallery image 3" class="gallery__img">
                </figure>
                <figure class="gallery__item gallery__item--4">
                    <img src="https://theatlasheart.com/wp-content/uploads/2015/09/12-IMG_1536-775x522.jpg" alt="Gallery image 4" class="gallery__img">
                </figure>
                <figure class="gallery__item gallery__item--5">
                    <img src="https://d37xww59oglu30.cloudfront.net/general/home-hero-taps.jpg" alt="Gallery image 5" class="gallery__img">
                </figure>
                <figure class="gallery__item gallery__item--6">
                    <img src="https://a9p9n2x2.stackpathcdn.com/wp-content/blogs.dir/1/files/2022/02/black-owned-breweries.jpg" alt="Gallery image 6" class="gallery__img">
                </figure>
            </div>
        </div>
        </body>
</template>

<script>
export default {
    name: 'brewery-gallery',

}
</script>

<style>
*,
*::after,
*::before {
  margin: 0;
  padding: 0;
  box-sizing: inherit; 
}

.container {
  width: 75%;
  margin: 1rem auto; 
}

.gallery {
  display: grid;
  grid-template-columns: repeat(8, 1fr);
  grid-template-rows: repeat(8, 5vw);
  grid-gap: 1rem; 
}

.gallery__img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block; 
}

.gallery__item--1 {
  grid-column-start: 1;
  grid-column-end: 3;
  grid-row-start: 1;
  grid-row-end: 3;

  /** Alternative Syntax **/
  /* grid-column: 1 / span 2;  */
  /* grid-row: 1 / span 2; */
}

.gallery__item--2 {
  grid-column-start: 3;
  grid-column-end: 5;
  grid-row-start: 1;
  grid-row-end: 3;

  /** Alternative Syntax **/
  /* grid-column: 3 / span 2;  */
  /* grid-row: 1 / span 2; */
}

.gallery__item--3 {
  grid-column-start: 5;
  grid-column-end: 9;
  grid-row-start: 1;
  grid-row-end: 6;

  /** Alternative Syntax **/
  /* grid-column: 5 / span 4;
  grid-row: 1 / span 5; */
}

.gallery__item--4 {
  grid-column-start: 1;
  grid-column-end: 5;
  grid-row-start: 3;
  grid-row-end: 6;

  /** Alternative Syntax **/
  /* grid-column: 1 / span 4;  */
  /* grid-row: 3 / span 3; */
}

.gallery__item--5 {
  grid-column-start: 1;
  grid-column-end: 5;
  grid-row-start: 6;
  grid-row-end: 9;

  /** Alternative Syntax **/
  /* grid-column: 1 / span 4; */
  /* grid-row: 6 / span 3; */
}

.gallery__item--6 {
  grid-column-start: 5;
  grid-column-end: 9;
  grid-row-start: 6;
  grid-row-end: 9;

  /** Alternative Syntax **/
  /* grid-column: 5 / span 4; */
  /* grid-row: 6 / span 3; */
}
</style>