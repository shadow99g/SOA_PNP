<!DOCTYPE html>
<html>
    <head>
        <title>Mapa</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <link href="Css/bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"/>

        <meta charset="utf-8"/>
        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 90%;
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }

            body { background-color:  #BDBDBD; }
        </style>
    </head>
    <body>
        <div id="map"></div>

        <script>
            var map, infoWindow;



            function obtenerValorParametro(sParametroNombre) {
                var sPaginaURL = window.location.search.substring(1);
                var sURLVariables = sPaginaURL.split('&');
                for (var i = 0; i < sURLVariables.length; i++) {
                    var sParametro = sURLVariables[i].split('=');
                    if (sParametro[0] == sParametroNombre) {
                        return sParametro[1];
                    }
                }
                return null;
            }
            var lt = obtenerValorParametro("lt");
            var ln = obtenerValorParametro("ln");
            console.log(lt, "", ln);
            

            function initMap() {
                infoWindow = new google.maps.InfoWindow;
                var directionsService = new google.maps.DirectionsService;
                var directionsDisplay = new google.maps.DirectionsRenderer;
                                // Try HTML5 geolocation.
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {

                        map = new google.maps.Map(document.getElementById('map'), {
                            center: {lat: position.coords.latitude,
                                lng: position.coords.longitude},
                            zoom: 12
                        });


                        directionsDisplay.setMap(map);

                        directionsService.route({
                            origin: {lat: position.coords.latitude, lng: position.coords.longitude}, //db waypoint start
                            destination: { lat: parseFloat(lt), lng: parseFloat(ln) }, //db waypoint end
                            travelMode: google.maps.TravelMode.WALKING
                        }, function (response, status) {
                            if (status === google.maps.DirectionsStatus.OK) {
                                directionsDisplay.setDirections(response);
                            } else {
                                window.alert('Ha fallat la comunicació amb el mapa a causa de: ' + status);
                            }
                        });

                    });
                }
            }

            function handleLocationError(browserHasGeolocation, infoWindow, pos) {
                infoWindow.setPosition(pos);
                infoWindow.setContent(browserHasGeolocation ?
                        'Error: The Geolocation service failed.' :
                        'Error: Your browser doesn\'t support geolocation.');
                infoWindow.open(map);
            }
        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5jlueIk_UWw2Pv4OjA2xtgnoXnI5YmVA&libraries=drawing&callback=initMap">
        </script>
        <br>
        <!--<a class="btn btn-success" href="index.xhtml">Listado de RJ</a>-->
        <br><br>
    </body>
</html>