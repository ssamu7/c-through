<template>
  <div id="app">
      <v-card>
        <v-toolbar
            color="light-green"
            height="60px"
            dark
            flat
            prominent
        >
          <template v-slot:default>
            <v-tabs
                v-model="tabs"
                centered
            >
              <v-tab>커피(caffeine)</v-tab>
              <v-tab>커피(non-caffeine)</v-tab>
              <v-tab>주스</v-tab>
              <v-tab>티</v-tab>

            </v-tabs>
          </template>
        </v-toolbar>

        <v-tabs-items v-model="tabs">
          <v-tab-item>
            <v-card flat>
              <v-card-title class="headline" style="justify-content: center">
                커피(caffeine)
              </v-card-title>
              <v-card-text>
                <CardGrid :events="events1" :buttonText="'Register'" @buttonClicked="eventHandler" />
              </v-card-text>
            </v-card>
          </v-tab-item>
          <v-tab-item>
            <v-card flat>
              <v-card-title class="headline" style="justify-content: center">
                커피(non-caffeine)
              </v-card-title>
              <v-card-text>
                <CardGrid :events="events2" :buttonText="'Register'" @buttonClicked="eventHandler" />
              </v-card-text>
            </v-card>
          </v-tab-item>
          <v-tab-item>
            <v-card flat>
              <v-card-title class="headline" style="justify-content: center">
                주스(Juice)
              </v-card-title>
              <v-card-text>
                <CardGrid :events="events3" :buttonText="'Register'" @buttonClicked="eventHandler" />
              </v-card-text>
            </v-card>
          </v-tab-item>
          <v-tab-item>
            <v-card flat>
              <v-card-title class="headline" style="justify-content: center">
                티(Tea)
              </v-card-title>
              <v-card-text>
                <CardGrid :events="events4" :buttonText="'Register'" @buttonClicked="eventHandler" />
              </v-card-text>
            </v-card>
          </v-tab-item>
        </v-tabs-items>
      </v-card>
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
      tabs: null,
      text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
      events1: [
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
      ],
      events2: [
        {
          name: "아이스라떼",
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
      ],
      events3: [
        {
          name: "수박주스",
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
      ],
      events4: [
        {
          name: "동준이가 좋아하는 아이스티",
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

<style>
.title {
  color: Black;
  text-align: center;
  font-size: 5vw;
  font-weight: 700;
  padding: 30px 0;
}
.vps-main-content {
  padding: 0;
}

@media only screen and (max-width: 768px) {
  .title {
    font-size: 10vw;
  }
}

</style>
