<!DOCTYPE html>
<html>
  <head>
    <title>Mapa</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
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
      .btn {
    background-color: DodgerBlue;
    border: none;
    color: white;
    padding: 12px 30px;
    cursor: pointer;
    font-size: 20px;
}

/* Darker background on mouse-over */
.btn:hover {
    background-color: RoyalBlue;
}
body { background-color:  #BDBDBD; }
    </style>

  </head>
  <body>
    <div id="map"></div>
    <script>
      // Note: This example requires that you consent to location sharing when
      // prompted by your browser. If you see the error "The Geolocation service
      // failed.", it means you probably did not give permission for the browser to
      // locate you.
      var map, infoWindow;
      function initMap() {
        
        infoWindow = new google.maps.InfoWindow;
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {

map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: position.coords.latitude,
              lng: position.coords.longitude},
          zoom: 12
        });

            
            directionsDisplay.setMap(map);

            directionsService.route({
            origin: { lat: position.coords.latitude, lng: position.coords.longitude },//db waypoint start
            destination: { lat: -13.078075, lng: -76.387277 },//db waypoint end
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
<a class="btn" href="index.xhtml">Listado de RJ</a>
<br><br>
  </body>
</html>