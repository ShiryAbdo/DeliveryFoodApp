package com.shimoo.foodorderapp.models;

import java.util.List;

public class Restaurants
{




    private int results_found;
    private int results_start;
    private int results_shown;
    private List<RestaurantsBean> restaurants;

    public int getResults_found() {
        return results_found;
    }

    public void setResults_found(int results_found) {
        this.results_found = results_found;
    }

    public int getResults_start() {
        return results_start;
    }

    public void setResults_start(int results_start) {
        this.results_start = results_start;
    }

    public int getResults_shown() {
        return results_shown;
    }

    public void setResults_shown(int results_shown) {
        this.results_shown = results_shown;
    }

    public List<RestaurantsBean> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantsBean> restaurants) {
        this.restaurants = restaurants;
    }

    public static class RestaurantsBean {
        /**
         * restaurant : {"R":{"res_id":5915530},"apikey":"ae5c9df3cbde209f3c36e8d9f7b47700","id":"5915530","name":"Nusr-Et Steakhouse","url":"https://www.zomato.com/istanbul/nusr-et-steakhouse-etiler-merkez-istanbul?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","location":{"address":"Etiler Mahallesi, Nispetiye Caddesi, No 87, Beşiktaş, İstanbul 34337","locality":"Etiler Merkez","city":"İstanbul","city_id":59,"latitude":"41.0802587010","longitude":"29.0334424004","zipcode":"34337","country_id":208,"locality_verbose":"Etiler Merkez, İstanbul"},"switch_to_order_menu":0,"cuisines":"Steak","average_cost_for_two":400,"price_range":4,"currency":"TL","offers":[],"opentable_support":0,"is_zomato_book_res":0,"mezzo_provider":"OTHER","is_book_form_web_view":0,"book_form_web_view_url":"","book_again_url":"","thumb":"https://b.zmtcdn.com/data/res_imagery/5915530_RESTAURANT_1413559867_3523edd7a23e120aacb1f7ea68e4622d_c.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A","user_rating":{"aggregate_rating":"4.5","rating_text":"Excellent","rating_color":"3F7E00","votes":"1593"},"photos_url":"https://www.zomato.com/istanbul/nusr-et-steakhouse-etiler-merkez-istanbul/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop","menu_url":"https://www.zomato.com/istanbul/nusr-et-steakhouse-etiler-merkez-istanbul/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop","featured_image":"https://b.zmtcdn.com/data/res_imagery/5915530_RESTAURANT_1413559867_3523edd7a23e120aacb1f7ea68e4622d_c.jpg","has_online_delivery":0,"is_delivering_now":0,"include_bogo_offers":true,"deeplink":"zomato://restaurant/5915530","is_table_reservation_supported":0,"has_table_booking":0,"events_url":"https://www.zomato.com/istanbul/nusr-et-steakhouse-etiler-merkez-istanbul/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1","establishment_types":[]}
         */

        private RestaurantBean restaurant;

        public RestaurantBean getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(RestaurantBean restaurant) {
            this.restaurant = restaurant;
        }

        public static class RestaurantBean {
            /**
             * R : {"res_id":5915530}
             * apikey : ae5c9df3cbde209f3c36e8d9f7b47700
             * id : 5915530
             * name : Nusr-Et Steakhouse
             * url : https://www.zomato.com/istanbul/nusr-et-steakhouse-etiler-merkez-istanbul?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
             * location : {"address":"Etiler Mahallesi, Nispetiye Caddesi, No 87, Beşiktaş, İstanbul 34337","locality":"Etiler Merkez","city":"İstanbul","city_id":59,"latitude":"41.0802587010","longitude":"29.0334424004","zipcode":"34337","country_id":208,"locality_verbose":"Etiler Merkez, İstanbul"}
             * switch_to_order_menu : 0
             * cuisines : Steak
             * average_cost_for_two : 400
             * price_range : 4
             * currency : TL
             * offers : []
             * opentable_support : 0
             * is_zomato_book_res : 0
             * mezzo_provider : OTHER
             * is_book_form_web_view : 0
             * book_form_web_view_url :
             * book_again_url :
             * thumb : https://b.zmtcdn.com/data/res_imagery/5915530_RESTAURANT_1413559867_3523edd7a23e120aacb1f7ea68e4622d_c.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A
             * user_rating : {"aggregate_rating":"4.5","rating_text":"Excellent","rating_color":"3F7E00","votes":"1593"}
             * photos_url : https://www.zomato.com/istanbul/nusr-et-steakhouse-etiler-merkez-istanbul/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop
             * menu_url : https://www.zomato.com/istanbul/nusr-et-steakhouse-etiler-merkez-istanbul/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop
             * featured_image : https://b.zmtcdn.com/data/res_imagery/5915530_RESTAURANT_1413559867_3523edd7a23e120aacb1f7ea68e4622d_c.jpg
             * has_online_delivery : 0
             * is_delivering_now : 0
             * include_bogo_offers : true
             * deeplink : zomato://restaurant/5915530
             * is_table_reservation_supported : 0
             * has_table_booking : 0
             * events_url : https://www.zomato.com/istanbul/nusr-et-steakhouse-etiler-merkez-istanbul/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1
             * establishment_types : []
             */

            private RBean R;
            private String apikey;
            private String id;
            private String name;
            private String url;
            private LocationBean location;
            private int switch_to_order_menu;
            private String cuisines;
            private int average_cost_for_two;
            private int price_range;
            private String currency;
            private int opentable_support;
            private int is_zomato_book_res;
            private String mezzo_provider;
            private int is_book_form_web_view;
            private String book_form_web_view_url;
            private String book_again_url;
            private String thumb;
            private UserRatingBean user_rating;
            private String photos_url;
            private String menu_url;
            private String featured_image;
            private int has_online_delivery;
            private int is_delivering_now;
            private boolean include_bogo_offers;
            private String deeplink;
            private int is_table_reservation_supported;
            private int has_table_booking;
            private String events_url;
            private List<Object> offers;
            private List<Object> establishment_types;

            public RBean getR() {
                return R;
            }

            public void setR(RBean R) {
                this.R = R;
            }

            public String getApikey() {
                return apikey;
            }

            public void setApikey(String apikey) {
                this.apikey = apikey;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public int getSwitch_to_order_menu() {
                return switch_to_order_menu;
            }

            public void setSwitch_to_order_menu(int switch_to_order_menu) {
                this.switch_to_order_menu = switch_to_order_menu;
            }

            public String getCuisines() {
                return cuisines;
            }

            public void setCuisines(String cuisines) {
                this.cuisines = cuisines;
            }

            public int getAverage_cost_for_two() {
                return average_cost_for_two;
            }

            public void setAverage_cost_for_two(int average_cost_for_two) {
                this.average_cost_for_two = average_cost_for_two;
            }

            public int getPrice_range() {
                return price_range;
            }

            public void setPrice_range(int price_range) {
                this.price_range = price_range;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public int getOpentable_support() {
                return opentable_support;
            }

            public void setOpentable_support(int opentable_support) {
                this.opentable_support = opentable_support;
            }

            public int getIs_zomato_book_res() {
                return is_zomato_book_res;
            }

            public void setIs_zomato_book_res(int is_zomato_book_res) {
                this.is_zomato_book_res = is_zomato_book_res;
            }

            public String getMezzo_provider() {
                return mezzo_provider;
            }

            public void setMezzo_provider(String mezzo_provider) {
                this.mezzo_provider = mezzo_provider;
            }

            public int getIs_book_form_web_view() {
                return is_book_form_web_view;
            }

            public void setIs_book_form_web_view(int is_book_form_web_view) {
                this.is_book_form_web_view = is_book_form_web_view;
            }

            public String getBook_form_web_view_url() {
                return book_form_web_view_url;
            }

            public void setBook_form_web_view_url(String book_form_web_view_url) {
                this.book_form_web_view_url = book_form_web_view_url;
            }

            public String getBook_again_url() {
                return book_again_url;
            }

            public void setBook_again_url(String book_again_url) {
                this.book_again_url = book_again_url;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public UserRatingBean getUser_rating() {
                return user_rating;
            }

            public void setUser_rating(UserRatingBean user_rating) {
                this.user_rating = user_rating;
            }

            public String getPhotos_url() {
                return photos_url;
            }

            public void setPhotos_url(String photos_url) {
                this.photos_url = photos_url;
            }

            public String getMenu_url() {
                return menu_url;
            }

            public void setMenu_url(String menu_url) {
                this.menu_url = menu_url;
            }

            public String getFeatured_image() {
                return featured_image;
            }

            public void setFeatured_image(String featured_image) {
                this.featured_image = featured_image;
            }

            public int getHas_online_delivery() {
                return has_online_delivery;
            }

            public void setHas_online_delivery(int has_online_delivery) {
                this.has_online_delivery = has_online_delivery;
            }

            public int getIs_delivering_now() {
                return is_delivering_now;
            }

            public void setIs_delivering_now(int is_delivering_now) {
                this.is_delivering_now = is_delivering_now;
            }

            public boolean isInclude_bogo_offers() {
                return include_bogo_offers;
            }

            public void setInclude_bogo_offers(boolean include_bogo_offers) {
                this.include_bogo_offers = include_bogo_offers;
            }

            public String getDeeplink() {
                return deeplink;
            }

            public void setDeeplink(String deeplink) {
                this.deeplink = deeplink;
            }

            public int getIs_table_reservation_supported() {
                return is_table_reservation_supported;
            }

            public void setIs_table_reservation_supported(int is_table_reservation_supported) {
                this.is_table_reservation_supported = is_table_reservation_supported;
            }

            public int getHas_table_booking() {
                return has_table_booking;
            }

            public void setHas_table_booking(int has_table_booking) {
                this.has_table_booking = has_table_booking;
            }

            public String getEvents_url() {
                return events_url;
            }

            public void setEvents_url(String events_url) {
                this.events_url = events_url;
            }

            public List<Object> getOffers() {
                return offers;
            }

            public void setOffers(List<Object> offers) {
                this.offers = offers;
            }

            public List<Object> getEstablishment_types() {
                return establishment_types;
            }

            public void setEstablishment_types(List<Object> establishment_types) {
                this.establishment_types = establishment_types;
            }

            public static class RBean {
                /**
                 * res_id : 5915530
                 */

                private int res_id;

                public int getRes_id() {
                    return res_id;
                }

                public void setRes_id(int res_id) {
                    this.res_id = res_id;
                }
            }

            public static class LocationBean {
                /**
                 * address : Etiler Mahallesi, Nispetiye Caddesi, No 87, Beşiktaş, İstanbul 34337
                 * locality : Etiler Merkez
                 * city : İstanbul
                 * city_id : 59
                 * latitude : 41.0802587010
                 * longitude : 29.0334424004
                 * zipcode : 34337
                 * country_id : 208
                 * locality_verbose : Etiler Merkez, İstanbul
                 */

                private String address;
                private String locality;
                private String city;
                private int city_id;
                private String latitude;
                private String longitude;
                private String zipcode;
                private int country_id;
                private String locality_verbose;

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getLocality() {
                    return locality;
                }

                public void setLocality(String locality) {
                    this.locality = locality;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public int getCity_id() {
                    return city_id;
                }

                public void setCity_id(int city_id) {
                    this.city_id = city_id;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                public String getZipcode() {
                    return zipcode;
                }

                public void setZipcode(String zipcode) {
                    this.zipcode = zipcode;
                }

                public int getCountry_id() {
                    return country_id;
                }

                public void setCountry_id(int country_id) {
                    this.country_id = country_id;
                }

                public String getLocality_verbose() {
                    return locality_verbose;
                }

                public void setLocality_verbose(String locality_verbose) {
                    this.locality_verbose = locality_verbose;
                }
            }

            public static class UserRatingBean {
                /**
                 * aggregate_rating : 4.5
                 * rating_text : Excellent
                 * rating_color : 3F7E00
                 * votes : 1593
                 */

                private String aggregate_rating;
                private String rating_text;
                private String rating_color;
                private String votes;

                public String getAggregate_rating() {
                    return aggregate_rating;
                }

                public void setAggregate_rating(String aggregate_rating) {
                    this.aggregate_rating = aggregate_rating;
                }

                public String getRating_text() {
                    return rating_text;
                }

                public void setRating_text(String rating_text) {
                    this.rating_text = rating_text;
                }

                public String getRating_color() {
                    return rating_color;
                }

                public void setRating_color(String rating_color) {
                    this.rating_color = rating_color;
                }

                public String getVotes() {
                    return votes;
                }

                public void setVotes(String votes) {
                    this.votes = votes;
                }
            }
        }
    }
}
