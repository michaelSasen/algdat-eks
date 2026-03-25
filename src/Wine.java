
/* ==============================================================================
* RECORD OF WINE CHART
* using records as they are immutable
* syntax is tidy and compact
============================================================================== */

public record Wine(double fixed_acidity, double volatile_acidity, double citric_acid, double residual_sugar, double chlorides, int free_sulfur_dioxide, int total_sulfur_dioxide, double density, double pH, double sulphates, double alcohol, int quality ) {
}
