public class Frete {
    private float routeDistance;
    private int routRegion;
    private int parts;
    private boolean track;


    public float getRouteDistance() {
        return routeDistance;
    }

    public void setRouteDistance(float routeDistance) {
        this.routeDistance = routeDistance;
    }

    public int getRoutRegion() {
        return routRegion;
    }

    public void setRoutRegion(int routRegion) {
        this.routRegion = routRegion;
    }

    public int getParts() {
        return parts;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }

    public boolean isTrack() {
        return track;
    }

    public void setTrack(boolean track) {
        this.track = track;
    }

    public float calculateFreightPerKM() {
        final float FUEL_PRICE = 5.90f;
        return getRouteDistance() * FUEL_PRICE;
    }

    public float calculateTrackFreight() {
        return isTrack() ? 200.00f : 0.00f;
    }

    public float calculatePartsFreight() {
        float[] fees = {1.0f, 1.2f, 1.3f};
        float[] discounts = {10.0f, 12.0f, 13.0f};
        float freight = getParts() * fees[getRoutRegion() - 1];
        float discount = (getParts() - 1000) * fees[getRoutRegion() - 1] * discounts[getRoutRegion() - 1] / 100;
        return (getParts() <= 1000) ? freight : freight - discount;
    }

    public float calculateTotalFreight() {
        return calculateTrackFreight() + calculateFreightPerKM() + calculatePartsFreight();
    }
}




