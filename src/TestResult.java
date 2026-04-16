public record TestResult(String algorithmName,
                         int repetitions,
                         boolean wasShuffled,
                         long totalTimeNano,
                         long comparisons,
                         String metricLabel) {
}
