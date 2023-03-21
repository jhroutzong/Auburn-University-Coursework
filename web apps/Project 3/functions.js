function outputCountryBox(name, continent, cities, photos) {

    let a = 0;
    while (a < countries.length) {
        function outputCities() {
            document.write(countries[a]["cities"])
        }

        function outputPhotos() {
            document.write(countries[a]["photos"])
        }
    }

    a = a + 1
}
