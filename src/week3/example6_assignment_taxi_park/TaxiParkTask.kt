package week3.example6_assignment_taxi_park

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
        //allDrivers.minus(trips.map { it.driver }) - better performance. Only 1 iteration
        allDrivers.filter { itDriver -> trips.none { it.driver == itDriver } }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
        allPassengers
                .filter { itPassenger -> trips.count { itPassenger in it.passengers } >= minTrips }
                .toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
        allPassengers
                .filter { itPassenger -> trips.count { itPassenger in it.passengers && it.driver == driver } > 1 }
                .toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val (tripsDiscount, tripsNoDiscount) = trips.partition { it.discount != null }
    return allPassengers
            .filter { p ->
                (tripsDiscount.count { p in it.passengers } ) >
                        (tripsNoDiscount.count { p in it.passengers })
            }.toSet()
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    val maxDuration = trips.map { it.duration / 10 }.groupBy { it }.maxBy { it.value.size }?.key ?: return null
    return (maxDuration * 10).rangeTo(maxDuration * 10 + 9)
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    val numDrivers20 = (allDrivers.size * 0.20).toInt()
    val totalIncome = trips.sumByDouble(Trip::cost)
    val incomeOf20 = allDrivers
            .map { d -> trips.filter { it.driver == d }.sumByDouble(Trip::cost) }
            .sortedDescending()
            .take(numDrivers20)
            .sum()
    return (incomeOf20 / totalIncome) >= 0.8
}