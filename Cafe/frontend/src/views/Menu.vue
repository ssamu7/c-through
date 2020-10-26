<template>
  <div class="menu">
    <h1 class="title">M E N U</h1>
    <CardGrid :events="events" :buttonText="'Register'" @buttonClicked="eventHandler" />
  </div>
</template>

<script>
import CardGrid from "@/components/Card/CardGrid";

export default {
  name: "Menu",
  components: {
    CardGrid
  },
  data() {
    return {
      events: [
        {
          name: "아메키라노",
          date: "October 11, 2019",
          description:
              "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem veritatis ea sint voluptatum vel rerum ipsum illo architecto repellat debitis corporis ex, ut explicabo! Voluptatum commodi dignissimos nihil cumque mollitia?",
          html:
              "<br><p>This paragraph is created using <br> custom <br> HTML</p>",
          outerImage: "https://lh3.googleusercontent.com/proxy/7jnrhIHRr0fW4gwXJU_J4UxLcmbwWVJAQau0DeCG7ggzi353272lRM9OtxZwp0mUTWpYtUG5Zymqk1T3PLzWE6PF7O-b6ksK3j_UKu9Uglck_Xn-2jw1iBfnjTCrx4teaLz3LhiEPu-XuKTqLMew9WcevSB0egnk2qhVtJWTdDPRrukqsJIqEFTvSl4zXg5GLMh5WvlxYW3cl6Em2sgP3qgVU8Z5Uz-aLJ-JZuQIsKyvlOckoLcBsGTw2oDSvNA7TIW75Z42R1nT2GDABd3Af8KP6a2Ypr5LAPsjyokYh59H7-mTgYNtB4Ra11H4yPFk2GuhY4urso99wNCbYhi0NHVz6doHI0FXR-7evQh9tdTqrrU",
          innerImage: "assets/images/1.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        },
        {
          name: "카페라떼",
          date: "October 11, 2019",
          description:
              "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem veritatis ea sint voluptatum vel rerum ipsum illo architecto repellat debitis corporis ex, ut explicabo! Voluptatum commodi dignissimos nihil cumque mollitia?",
          outerImage: "assets/images/2.jpg",
          innerImage: "assets/images/hackathon.jpg",
          details: {
            "Team Size": "2",
            Time: "12PM - 8PM"
          }
        },
        {
          name: "Treasure Hunt",
          date: "October 12, 2019",
          description:
              "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem veritatis ea sint voluptatum vel rerum ipsum illo architecto repellat debitis corporis ex, ut explicabo! Voluptatum commodi dignissimos nihil cumque mollitia?",
          outerImage: "assets/images/3.jpg",
          innerImage: "assets/images/treasure.jpg",
          details: {
            "Team Size": "2",
            Time: "4PM - 6PM"
          }
        },
        {
          name: "Marvel Quiz",
          date: "October 13, 2019",
          description:
              "Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem veritatis ea sint voluptatum vel rerum ipsum illo architecto repellat debitis corporis ex, ut explicabo! Voluptatum commodi dignissimos nihil cumque mollitia?",
          outerImage: "assets/images/4.jpg",
          innerImage: "assets/images/marvel.jpg",
          details: {
            "Team Size": "2",
            Time: "3PM - 5PM"
          }
        }
      ]
    };
  },
  props: {
    place: String
  },
  methods: {
    eventHandler() {
      console.log('button clicked');
    }
  },
  mounted() {
    console.log("place props : " + this.place)
  }
};
</script>

<style scoped>
.title {
  color: Black;
  text-align: center;
  font-size: 5vw;
  font-weight: 700;
  padding: 30px 0;
}

@media only screen and (max-width: 768px) {
  .title {
    font-size: 10vw;
  }
}
</style>
